const express = require('express');
const bodyParser = require('body-parser');
const app = express();
const cors = require('cors');
const mongoose = require('mongoose');

// Variables for Routers
const taskyRoutes = express.Router();
const tasky = require('./model/week3.model');

app.use(cors());
app.use(bodyParser.json());
mongoose.connect('mongodb+srv://ujjwalpoudel2003:y4RMoZ5jZbUmT84O@cluster0.zppmvxc.mongodb.net/?retryWrites=true&w=majority&appName=AtlasApp', {useNewUrlParser:true});

const connection = mongoose.connection;
connection.once('open', () => {
    console.log('DB Connected...')
});

taskyRoutes.route('/')
                .get((req, res) => {
                    tasky.find((tasky, err) => {
                        if(err)
                            console.log(err)
                    else
                        res.json(tasky)
                    })
                });

taskyRoutes.route('/:id')
                    .get((req, res) => {
                     const id = req.params.id;
                     tasky.findById(id, (tasky, err) => {
                         if(err)
                             console.log(err)
                     else
                         res.json(tasky)
                     })
                });

app.use(taskyRoutes);

app.listen(8081, () => {
    console.log("server is running on 8081")
});