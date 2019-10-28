module.exports = {
    devServer: {
        proxy: {
            '/apix': {
                target: 'http://localhost:9090/',
                secure: false
            }
        }
    },
    transpileDependencies: [
        /\bvue-awesome\b/
    ]
}