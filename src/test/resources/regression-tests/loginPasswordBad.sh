#18
# Prueba la validacion de cuando se envia un paswword erroneo, regresa un status de error

curl -X POST --header "Content-Type: application/json" --header "Accept: application/json;charset=utf-8" -d "{
  \"password\": \"felixPassBad\",
  \"user\": \"felix\"
}" "http://localhost:8080/api/chatbot/auth/login.json"