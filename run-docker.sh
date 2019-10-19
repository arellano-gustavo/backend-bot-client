
echo "Corriendo el aplicativo con un perfil determinado con docker"

docker run -it \
-p 8080:8080 \
-v /home/chatbot/source-code/impi-chatbot-admin:/chat \
gustavoarellano/jdk18 


