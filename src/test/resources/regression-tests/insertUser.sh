#03
# Inserta un 'User' en el sistema y regresa un objeto 'MainControllerResponse' con el resultado de la operacion.

curl -X POST --header "Content-Type: application/json" --header "Accept: application/json;charset=utf-8" -d "{
  \"bloquedAccount\": true,
  \"bloquedDate\": \"2019-09-25T16:53:48.029Z\",
  \"creationDate\": \"2019-09-25T16:53:48.029Z\",
  \"disabled\": true,
  \"expiredAccount\": true,
  \"expiredCredential\": true,
  \"failedAtemptCounter\": 0,
  \"id\": 1,
  \"lastAccessDate\": \"2019-09-25T16:53:48.029Z\",
  \"lastPasswordUpdateDate\": \"2019-09-25T16:53:48.029Z\",
  \"mail\": \"correo@mail.com\",
  \"password\": \"felixpass\",
  \"secretAnswer\": \"bien\",
  \"secretQuestion\": \"como estas\",
  \"securityToken\": \"\",
  \"securityTokenWindow\": 0,
  \"usr\": \"felix\"
}" "http://localhost:8080/api/chatbot/admin/insert-user.json"