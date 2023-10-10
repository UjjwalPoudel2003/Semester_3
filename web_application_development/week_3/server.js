const express = require('express');
const bodyParser = require('body-parser');
const app = express();
const cors = require('cors');
const mongoose = require('mongoose');

// Variables for Routers
const taskyRoutes = express.Router();
const Tasky = require('./model/week3.model');

app.use(cors());
app.use(bodyParser.json());
mongoose.connect('mongodb+srv://ujjwalpoudel2003:y4RMoZ5jZbUmT84O@cluster0.zppmvxc.mongodb.net/?retryWrites=true&w=majority&appName=AtlasApp', { useNewUrlParser: true });

const connection = mongoose.connection;
connection.once('open', () => {
    console.log('DB Connected...')
});

taskyRoutes.route('/')
    .get((req, res) => {
        Tasky.find()
        .then(tasky => res.status(200).json(tasky))
        .catch(err => res.status(400).json({"error": err}))
    });

taskyRoutes.route('/:id').get((req, res) => {
    Tasky.findById(req.params.id)
    .then(tasky => res.status(200).json(tasky))
    .catch(err => res.status(400).json({"error": err}))
})

taskyRoutes.route('/add').post((req, res) => {
    let tasky = new Tasky(req.body)
    tasky.save()
        .then(tasky => res.status(200).json(tasky))
        .catch(err => res.status(400).json({"error": err}))
});

taskyRoutes.route('/update/:id').post((req, res) => {
    Tasky.findById(req.params.id)
    .then(tasky => {
        // Update the object with new data
        tasky.tasky_description = req.body.tasky_description;
        tasky.tasky_responsible = req.body.tasky_responsible;
        tasky.priority = req.body.tasky_priority;
        tasky.tasky_completed = req.body.tasky_completed;

        // Save new data
        
    })
})

app.use(taskyRoutes);

app.listen(8081, () => {
    console.log("server is running on 8081")
});