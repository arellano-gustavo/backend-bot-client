import Login from './components/04-LogIn/login.vue'
import masterUsr from './components/01-Usuario/masterUsuario.vue'
import masterAdm from './components/02-Administrador/masterAdmin.vue'
import intents from './components/05-Entrenador/01-Intentos/intents.vue'
import entities from './components/05-Entrenador/01-Intentos/entities.vue'
export const rutas = [{
        path: '',
        component: Login,
        name: 'login'
    },
    {
        path: '/masterUsr',
        component: masterUsr,
        name: 'masterUsr',
        children: [
            { path: 'intents', component: intents },
            { path: 'entities', component: entities }
        ]
    },
    {
        path: '/masterAdm',
        component: masterAdm
    }
];
export default rutas;