const { exception } = require('console');
const { request, response } = require('express');
const neDB = require('../configurations/database');
const { route } = require('../configurations/express');
const app = require('../configurations/express');
const api = {}


api.findAll = (request, response) => {

    neDB.find({}, (exception, cards) => {
        if(exception) {
            const errorMessageCustom = 'Error, cannot find all registers';
            console.log(errorMessageCustom, exception)
            response.status(exception.status | 400)
            response.json({'Message': errorMessageCustom})
        }

        response.status(200)
        response.json(cards)

    });
}

api.sort = (request, response) => {

    neDB.find({}).sort({customerName: 1}).exec( (exception, cards) => {
        if(exception) {
            const errorMessageCustom = 'Error, cannot find all registers';
            console.log(errorMessageCustom, exception)
            response.status(exception.status | 400)
            response.json({'Message': errorMessageCustom})
        }
        
        response.status(200)
        response.json(cards)
    })
}

api.findById = (request, response) => {

    neDB.findOne({_id: request.params._id}, (exception, card) => {
        if(exception) {
            const errorMessageCustom = 'Error, cannot find the register';
            console.log(errorMessageCustom, exception)
            response.status(exception.status | 400)
            response.json({'Message': errorMessageCustom})
        }

        response.status(200)
        response.json(card)
    })
}



api.save = (request, response) => {
    const canonical = request.body;

    neDB.insert(canonical, (exception, card) => {
        if(exception) {
            console.log('Error, cannot save the register')
            response.status(406)
        }

        response.status(201)
        response.json(card)
    })
}

api.remove = (request, response) => {
    neDB.remove({ _id: request.params._id }, {}, (exception, removedCard) => {
        if(exception) {
            console.log('Error, cannot remove the register')
            response.status(451)
        }
        removedCard = 1

        response.status(200)
        response.json(removedCard)        
    });
}

api.update = (request, response) => {
    neDB.update({ _id: request.params._id }, {request}, (exception, numReplaced) => {

        if(exception) {
            console.log('Error, cannot remove the register')
            response.status(400)
        }
        numReplaced = 1

        response.status(202)
        response.json(numReplaced)
    });
}

module.exports = api