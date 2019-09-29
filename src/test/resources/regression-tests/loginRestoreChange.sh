#20
# Cambia el passwors de un usuario por medio del objeto 'Login' 
# Regresa un objeto 'MainControllerResponse' con el resultado de la operacion.

curl -X POST --header "Content-Type: application/json" --header "Accept: application/json;charset=utf-8" -d "{
  \"password\": \"felixpass\",
  \"user\": \"felix\"
}" "http://localhost:8080/api/chatbot/auth/change-password.json"
