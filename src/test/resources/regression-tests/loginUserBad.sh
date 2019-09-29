#18
# Autentica el usuario el sistema por medio de las credenciales contenidas en el 'Login'
# Regresa 'LoginResponse' el cual contiene el resultado de la operacion, entre los datos
# de se encuentra el token con el cual se verifica si el usuario puede realizar operaciones

curl -X POST --header "Content-Type: application/json" --header "Accept: application/json;charset=utf-8" -d "{
  \"password\": \"felixpass\",
  \"user\": \"felixBad\"
}" "http://localhost:8080/api/chatbot/auth/login.json"
