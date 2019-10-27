RUTA=/Users/garellano/development/code/impi-chatbot-admin

echo "Corriendo el aplicativo con un perfil determinado con docker"
docker stop chatbot-backend
docker rm chatbot-backend

docker run -it \
-p 8080:8080 \
--name chatbot-backend \
--restart unless-stopped \
-v $RUTA/target:/chat \
-v $RUTA/log:/log \
-v /Users/garellano/Desktop/springboot-conf-dir:/configuration \
gustavoarellano/jdk18 \
java -jar \
-Dmaven.test.skip=true \
-Dspring-boot.run.profiles=home \
-Dspring.config.location="file:/configuration/" \
-Doracle.jdbc.timezoneAsRegion=false \
/chat/chatbot-persistence-layer-1.0.war

# Las siguientes lineas se DEBEN poner como volumenes cuando se este en el IMPI:

# RUTA=/home/chatbot/source-code/impi-chatbot-admin
# -v $RUTA:/chat
# -v $RUTA/log:/log
# y obviamente en el servidor debe exisistir el directorio "log"




