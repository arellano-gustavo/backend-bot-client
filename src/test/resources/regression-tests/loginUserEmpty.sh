#18
# Prueba la validacion de cuando se envia un usuario vacio, regresa un status de error

curl -X POST --header "Content-Type: application/json" --header "Accept: application/json;charset=utf-8" -d "{
  \"password\": \"felixpass\",
  \"user\": \"\"
}" "http://localhost:8080/api/chatbot/auth/login.json"