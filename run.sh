echo "Compilando, pero me salto los tests"
mvn clean package -Dmaven.test.skip=true

echo "Corriendo el aplicativo con un perfil determinado"
java -jar \
-Dspring-boot.run.profiles=impi \
-Doracle.jdbc.timezoneAsRegion=false \
target/chatbot-persistence-layer-1.0.war
