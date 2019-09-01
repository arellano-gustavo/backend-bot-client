  $( "#draggable" ).draggable();
  
  function callChat() {
	  var texto = $("#txt_input").val();
	  call(texto, 1, 35);
  }
  function call(challenge, area, uid) {
      var url1="http://api.kebblar.capital:9999/";
      var url2="http://localhost:8080/;
	  
      var datos1 = {"challenge":challenge, "area":area, "uid":uid};
      var datos = JSON.stringify(datos1);
      
      $.ajax({
          dataType: 'json',
          crossDomain: true,
          url: url2 + "api/chatbot",
          header: {
              'Content-Type': 'application/json',
              "cache-control": "no-cache"
          },
          data: datos,
          type: "POST",
          success: function(response) {
              // console.log(response);
              $('<div class=scrollarea-content>' + challenge + '</div>').appendTo('#entrada');
              $('<div class=scrollarea-content>' + response + '</div>').appendTo('#salida');
              var elem1 = document.getElementById('entrada');
              elem1.scrollTop = elem1.scrollHeight;
              var elem2 = document.getElementById('salida');
              elem2.scrollTop = elem2.scrollHeight;
          },
          error: function(xhr, status, errorThrown) {
              //Here the status code can be retrieved like;
              console.log(xhr.status);
              //The message added to Response object in Controller can be retrieved as following.                    
              console.log(xhr.responseText);
          }
      });
  }