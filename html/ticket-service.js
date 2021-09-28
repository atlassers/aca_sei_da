class TicketService {

    constructor() {}

    static getTicket(id) {
        BaseService.get('/tickets/v1', id).then(function (ticketDto) {
            return ticketDto;
        })
    }

    static getFilmOnTicket(id){
        BaseService.get('/films/v1', id).then(function (filmDto) {
            document.getElementById('titleFilm').innerHTML = '<label>' + filmDto.title + '</label>';
        })
    }

    static getTicketIdByFilmId(idFilm) {
        BaseService.get('/tickets/empty-ticket', "?id=" + idFilm).then(function (ticketDto) {
            //console.log("ticket id",ticketDto);
        })
    }

    static updateScreeningTime(ticket, time) {
        BaseService.put('/tickets/update-time/v1', ticket).then(function (ticketDto) {
            window.alert("Il biglietto è stato aggiornato")
            // ticketDto.id = 
            // ticketDto.time = time;
        })
    }

    // static updateFilmTime(ticket) {
    //     BaseService.patch('/tickets/v1', ticket).then(function (ticketDto) {
    //         ticketDto.
    //     })
    // }

    static createFoodPurchase(food) {
        BaseService.post('/food-purchases/v1', food).then(function (foodPurDto) {
            
        })
    }

    static updateFoodPurchase() {
        //POST con path di FoodPurchase

    }

    static getAllFood() {
        BaseService.getAll('/foods/v1').then(function (foods) {
            console.log(foods)
            let txt= '<ul>';
            foods.forEach(f => {
                txt += '<li>' + f.name + ' - € ' + f.unitPrice + '</li>'
            })
            txt += '</ul>'
            document.getElementById('foodList').innerHTML = txt;
        })
    }
}