const mongoose = require('mongoose');
const Schema = mongoose.Schema;

// YOU CAN ADD YOUR OWN SCHEMA HERE

let Todo = new Schema({
    description:{
        type:String
    },
    responsible:{
        type:String
    },
    priority:{
        type:String
    },
    isCompleted:{
        type:Boolean
    }
});

module.exports = mongoose.model('Todo',Todo);
