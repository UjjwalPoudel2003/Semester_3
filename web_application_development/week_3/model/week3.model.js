const mongoose = require('mongoose');

const Schema = mongoose.Schema;

const Tasky = new Schema({
    tasky_description: {
        type: String
    },

    tasky_responsible: {
        type: String
    },

    tasky_priority: {
        type: String
    },

    tasky_completed: {
        type: Boolean
    }
});

module.exports = mongoose.model('Tasky', Tasky);