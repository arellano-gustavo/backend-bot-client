import Vue from 'vue'
import App from './App.vue'
import store from './store'
import BootstrapVue from 'bootstrap-vue'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'
import VueRouter from 'vue-router'
import { rutas } from './rutas.js'
import axios from 'axios'
import VueAxios from 'vue-axios'
axios.defaults.baseURL = `http://localhost:9090`
Vue.config.productionTip = false
import EvaIcons from 'vue-eva-icons'
import ParticleBtn from "vue-particle-effect-buttons"
Vue.use(EvaIcons)
Vue.use(VueRouter)
Vue.use(VueAxios, axios)
Vue.use(BootstrapVue)
Vue.use(ParticleBtn)
const enrutador = new VueRouter({
    routes: rutas,
    mode: 'history'
})

new Vue({
    store,
    router: enrutador,
    render: h => h(App)
}).$mount('#app')