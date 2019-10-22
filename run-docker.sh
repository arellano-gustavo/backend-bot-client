RUTA=/Users/garellano/development/code/impi-chatbot-admin/target

echo "Corriendo el aplicativo con un perfil determinado con docker"

docker run -it \
-p 8080:8080 \
-v $RUTA:/chat \
gustavoarellano/jdk18 \
java -jar \
-Dmaven.test.skip=true \
-Dspring-boot.run.profiles=home \
-Doracle.jdbc.timezoneAsRegion=false \
/chat/chatbot-persistence-layer-1.0.war


# La siguiente linea se DEBE poner hasta arriba cuando aplique:
# RUTA=/home/chatbot/source-code/impi-chatbot-admin


