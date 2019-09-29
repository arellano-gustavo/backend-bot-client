#19
# Regresa un objeto 'MainControllerResponse' con el resultado de la operacion.

curl -X POST --header "Content-Type: application/json" --header "Accept: application/json;charset=utf-8" -d "correo@mail.com" "http://localhost:8080/api/chatbot/auth/request-restore.json"
