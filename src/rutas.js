import login from './components/login.vue'
import masterUsr from './components/01-Usuario/masterUsuario.vue'
import masterAdm from './components/02-Administrador/masterAdmin.vue'
export const rutas = [{
        path: '',
        component: login
    },
    {
        path: '/masterUsr',
        component: masterUsr
    },
    {
        path: '/masterAdm',
        component: masterAdm
    }
]