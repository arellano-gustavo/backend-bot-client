#11
#Obtiene un 'User' por medio de su mail

curl -X GET --header "Accept: application/json;charset=utf-8" "http://localhost:8080/api/chatbot/admin/get-user-by-mail.json?mail=correo@mail.com"