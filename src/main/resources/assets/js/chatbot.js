function scrolleer() {
    $("#exampleModalScrollable").find(".modal-body").animate({
        scrollTop: $("#exampleModalScrollable").find(".modal-body")[0].scrollHeight
    }, 1000);
}

function limpiar() {
    $("#txtcomment").val('');
    $("#txtcomment").focus();
}



function agregarPregunta(pregunta) {
    $("#inchat").html($("#inchat").html() + '<div class="card"><div class="card-body"><p class="card-text"><div class="text-justify"><img src="img/icon1.png" class="rounded-circle imgIMPI pull-right" alt="IMPI">' + pregunta + '</p></div></div></div>');
}

function callChat(pregunta,idarea) {
    //var datos = '{"texto":"' + pregunta + '"}';
	var datos1 = {"challenge":pregunta, "area":idarea, "uid":"123"};
      var datos = JSON.stringify(datos1);
    $.ajax({
        dataType: 'json',
        crossDomain: true,
        url: "http://chatbot.impi.gob.mx/api/chatbot",
        header: {
            'Content-Type': 'application/json',
            "cache-control": "no-cache"
        },
        data: datos,
        type: "POST",
        success: function(response) {
            console.log(response);
            $("#inchat").html($("#inchat").html() + '<div class="card"><div class="card-body"><p class="card-text"><div class="text-justify"><img src="img/impi.jpg" class="rounded-circle imgIMPI" alt="IMPI">' + response + '</p></div></div></div>');
            speak(response);
            scrolleer();
            limpiar();
        },
        error: function(xhr, status, errorThrown) {
            //Here the status code can be retrieved like;
            console.log(xhr.status);
            //The message added to Response object in Controller can be retrieved as following.                    
            console.log(xhr.responseText);
        }
    });
}
$(document).ready(function() {
    $("#draggable").draggable({
        zIndex: 2710,
        create: function(event, ui) {
            var height = window.innerHeight - 100;
            var width = window.innerWidth - 100;
            $("#draggable").css("bottom", -height);
            $("#draggable").css("right", -width);
            $(this).addClass("chatInicial");
        }
    });

    $("#exampleModalScrollable").draggable({
        zIndex: 2710
    });

    $("#enviar").click(function() {
        guardaPregunta();
    });
    $('#txtcomment').keyup(function(e) {
        if (e.keyCode == 13) {
            guardaPregunta();
        }
    });
});