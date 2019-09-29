#17
# Actualiza un 'User' en el sistema y regresa un objeto 'MainControllerResponse' con el resultado de la operacion 

curl -X PUT --header "Content-Type: application/json" --header "Accept: application/json;charset=utf-8" -d "{
  \"bloquedAccount\": false,
  \"bloquedDate\": \"2019-09-25T18:36:03.739Z\",
  \"creationDate\": \"2019-09-25T18:36:03.739Z\",
  \"disabled\": false,
  \"expiredAccount\": false,
  \"expiredCredential\": false,
  \"failedAtemptCounter\": 0,
  \"id\": 1,
  \"lastAccessDate\": \"2019-09-25T18:36:03.739Z\",
  \"lastPasswordUpdateDate\": \"2019-09-25T18:36:03.739Z\",
  \"mail\": \"felix@mail.com\",
  \"password\": \"d1139ea39e376cca38912653488738e9f9b252c603fcc2fbdf55a8c390624806\",
  \"secretAnswer\": \"mas o menos\",
  \"secretQuestion\": \"como estas\",
  \"securityToken\": \"stringToken\",
  \"securityTokenWindow\": 0,
  \"usr\": \"felix\"
}" "http://localhost:8080/api/chatbot/admin/update-user.json"