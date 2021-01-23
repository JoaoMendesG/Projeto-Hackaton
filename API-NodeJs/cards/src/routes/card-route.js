const { get } = require('../configurations/express')
const api = require('../controllers/card-controller')

module.exports = (app) => {
    app.route('/cards')
        .get(api.findAll)
        .post(api.save)

    app.route('/cards/:_id')
        .get(api.findById)
        .delete(api.remove)
        .put(api.update)

    app.route('/cards/paginationAndSorting')
        .get(api.sort)
}