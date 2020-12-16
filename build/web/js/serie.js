   function chck(){
   let serie = document.getElementById('episodio-switch');
    let temporada = document.getElementById('temporada-switch');
   
    serie.addEventListener('change',function(){
        if(serie.checked){
            temporada.checked=false;
        }
    })

    temporada.addEventListener('change',function(){
        if(temporada.checked){
            serie.checked=false;
        }
    })
}

