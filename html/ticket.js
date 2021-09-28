$(document).ready(function() {
    
    let url_str = window.location.href;
    let url = new window.URL(url_str);
    let filmId = url.searchParams.get("idFilm");
    let ticketId = TicketService.getTicketIdByFilmId(filmId);

    TicketService.getFilmOnTicket(filmId);

    TicketService.getAllFood();

    let ticket = TicketService.getTicket(ticketId);
    
    $('#btnTime1').click(function () {
        let time1 = 'Pomeriggio';
        console.log(ticket);
        TicketService.updateScreeningTime(ticket, time1);
        console.log(ticket);
    })

    $('#btnTime2').click(function () {
        let time2 = 'Sera';
        console.log(ticket);
        TicketService.updateScreeningTime(ticket, time2);
        console.log(ticket);
    })

    $('#btnTime3').click(function () {
        let time3 = 'Notte';
        console.log(ticket);
        TicketService.updateScreeningTime(ticket, time3);
        console.log(ticket);
    })

})