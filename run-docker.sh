
echo "Corriendo el aplicativo con un perfil determinado con docker"

docker run -it \
-p 8080:8080 \
-v /Users/garellano/development/code/impi-chatbot-admin/target:/chat \
gustavoarellano/jdk18 \
java -jar \
-Dspring-boot.run.profiles=home \
-Doracle.jdbc.timezoneAsRegion=false \
/chat/chatbot-persistence-layer-1.0.war



