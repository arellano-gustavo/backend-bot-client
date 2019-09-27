export RUTA=/users/davidcorza/proyectos/impi/chatbotAdm1/backend-bot-client
npm run build
cp -r $RUTA/dist/ $RUTA/fe/src/main/resources/assets
cp pom.xml $RUTA/fe
mvn -f $RUTA/fe/pom.xml package