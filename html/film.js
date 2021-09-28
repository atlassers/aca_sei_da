$(document).ready(function() {
        //TODO da mettere in ticket.js 
        // let url_str = window.location.href;
        // let url = new URL(url_str);
        // let filmId = url.searchParams.get("filmId");
        //TicketService.getTicketIdByFilmId(idFilm);
        FilmService.getAll();
})