curl -X PUT \
    https://rancher.ci.gustavo-arellano.com/v3/project/c-v2vwp:p-rw8nc/workloads/deployment:default:pba-service \
   -k \
   -H 'Authorization: Bearer token-xg65g:84wwxszfpjp75fpld2nv4rqmk7cg5c856pztdwvzq5bznbcw4xz655' \
   -H 'Content-Type: application/json' \
    -d@- <<DATA
    {  
        "scale":$1,
        "containers":[  
            {
            "name":"pba-service",
            "image":"nexus.ci.gustavo-arellano.com:5005/pba-service"
            }
        ]
    }
DATA
