export UPDATE=$(($(date +'%s * 1000 + %-N / 1000000')))
echo $UPDATE

cd ..

docker build /home/ubuntu/pba/ -t nexus.ci.gustavo-arellano.com:5005/pba-service
docker push nexus.ci.gustavo-arellano.com:5005/pba-service
pba/refresh.sh $UPDATE

