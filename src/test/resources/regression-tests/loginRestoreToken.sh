#21
# Valida el 'token' que se mando al correo de usuario para restaruear el password
# Regresa un objeto 'MainControllerResponse' con el resultado de la operacion

curl -X GET --header "Accept: application/json;charset=utf-8" -d "stringToken" "http://localhost:8080/api/chatbot/auth/validate-token.json"