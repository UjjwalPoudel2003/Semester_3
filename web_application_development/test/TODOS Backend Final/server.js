const express = require('express');
const app = express();
const bodyParser = require('body-parser');
const cors = require('cors');
const mongoose = require('mongoose');
// Routers
const todoRoutes = express.Router();
const Todo = require('./model/todos.model');


app.use(cors());
app.use(bodyParser.json());

mongoose.connect('mongodb+srv://upatel:Z3BmV2ofUb7LbJw9@cluster0.n0akqrt.mongodb.net/?retryWrites=true&w=majority',
{useNewUrlParser:true});

const connection = mongoose.connection;

connection.once('open',()=>{
    console.log("DB connected......")
})

// YOU WRITE YOUR CODE HERE
     todoRoutes.route('/').get((req, res)=>{
      Todo.find()
      .then(todos=>res.status(200).json(todos))
        .catch(err=>res.status(400).json({"error": err}))
     });

     todoRoutes.route('/:id').get((req,res)=>{
       Todo.findById(req.params.id)
      .then(todos=>res.status(200).json(todos))
        .catch(err=>res.status(400).json({"error": err}))
     })

     todoRoutes.route('/add').post((req,res)=>{
        
        let todo = new Todo(req.body)
          todo.save()
            .then(todos=>res.status(200).json(todos))
            .catch(err=>res.status(400).json({"error": err}))

     });

     
     todoRoutes.route('/update/:id').post((req,res)=>{
        Todo.findById(req.params.id)
        .then(todos=>{
            //Update the object with new data
            todos.description = req.body.description;
            todos.responsible = req.body.responsible;
            todos.priority = req.body.priority;
            todos.isCompleted = req.body.isCompleted;

            //Save new Data

            todos.save()
            .then(todos=>res.status(200).json(todos))
            .catch(err=>res.status(400).json({"error": err}))

            res.status(200).json(todos)
        })
          .catch(err=>res.status(400).json({"error": err}))
       });

app.use(todoRoutes);

app.listen(8081,()=>{
    console.log("Server is running on 8081....");
});