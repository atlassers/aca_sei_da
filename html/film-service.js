class FilmService {

    constructor() {}

    static getAll() {
        BaseService.getAll('/films/v1').then(function (filmDtoList) {
            console.log(filmDtoList);
            let txt = '';
            filmDtoList.forEach((f, i) => {
                txt += `<button id="${f.id}">`+ f.title +'</button>'
                console.log(f.title);
            })
           
            document.getElementById('body').innerHTML = txt;

            filmDtoList.forEach((f, i) => {
                document.getElementById(`${f.id}`).addEventListener('click' ,function(ev) {
                    console.log(ev.composedPath()[0]);
                    //dovrebbe fare chiamata POST per Ticket (ticket-service)
                    //POST: inserisco f.id (cioè id_film) e resto dei campi a null
                    window.location.href = "ticket.html?idFilm=" + `${f.id}`;
                })
            })
        })
    }

    static get(id) {
        BaseService.get('/films/v1', id).then(function(filmDto) {
            doc.getElementById('titleFilm').innerHTML = '<label>' + filmDto.title + '</label>';
        })
    }
}