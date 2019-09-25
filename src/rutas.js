import Login from './components/04-LogIn/login.vue'
import masterUsr from './components/01-Usuario/masterUsuario.vue'
import masterAdm from './components/02-Administrador/masterAdmin.vue'
export const rutas = [{
        path: '',
        component: Login
    },
    {
        path: '/masterUsr',
        component: masterUsr,
        name: 'masterUsr'
    },
    {
        path: '/masterAdm',
        component: masterAdm
    }
];
export default rutas;