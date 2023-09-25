// Imports
const express = require('express');
const morgan = require('morgan');
const compress = require('compression');
const bodyParser = require('body-parser');
const methodOverride = require('method-override');

module.exports = () => {
    const app = express();

    if(process.env.NODE_ENV === 'development'){
        app.use(morgan('Dev'));
    } else if(process.env.NODE_ENV === 'production'){
        app.use(morgan('Prod'));
        app.use(compress());
    }

    app.use(bodyParser.urlencoded({
        extended: true
    }));

    app.use(bodyParser.json());

    app.use(methodOverride());

    app.set('views', './app/views');
    app.set('view engine', 'ejs');
    app.use('/', require('../app/routes/index.server.routes.js'));

    app.use(express.static('./node_modules'));

    return app;
}