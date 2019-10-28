<template>
<div>
    <h1>Intentos</h1>
    <b-card no-body>
        <b-tabs card>
            <b-tab title="Contexto" active>
                <agregatexto :prepends="pre.prepends"></agregatexto>
                <mostrar :items="opciones.ContextoData"></mostrar>
            </b-tab>
            <b-tab title="Eventos">
                <b-card-text>
                    <agregar :opcionesTab="opciones.Eventos"></agregar>
                    <mostrar :items="opciones.EventosData"></mostrar>
                </b-card-text>
            </b-tab>
            <b-tab title="Frases">
                <b-card-text>
                    <agregar :opcionesTab="opciones.Frases"></agregar>
                    <mostrar :items="opciones.FraseData"></mostrar>
                </b-card-text>
            </b-tab>
            <b-tab title="Acciones y Parametros">
                <b-card-text>
                    <agregar :opcionesTab="opciones.AccionesP"></agregar>
                    <mostrar :items="opciones.AccionesData"></mostrar>
                </b-card-text>
            </b-tab>
            <b-tab title="Respuestas">
                <b-card-text>
                    <agregar :opcionesTab="opciones.Respuestas"></agregar>
                    <mostrar :items="opciones.RespuestasData"></mostrar>
                </b-card-text>
            </b-tab>
        </b-tabs>
    </b-card>
</div>
</template>

<script>
import agregar from '../../03-Generico/agregar.vue'
import mostrar from '../../03-Generico/mostrar.vue'
import agregatexto from './01-Contexto/contextoP.vue'
export default {
    components: {
        agregar,
        mostrar,
        agregatexto
    },
    data() {
        return {
            pre:{prepends:'Entrada/Salida'},
            opciones: {
                Eventos: 'Evento',
                EventosData: [{
                        Eventos: "Evento 1"
                    },
                    {
                        Eventos: "Evento 2"
                    },
                    {
                        Eventos: "Evento 3"
                    },
                    {
                        Eventos: "Evento 4"
                    }
                ],
                Frases: 'Frase',
                FraseData: [{
                        Frases: "Frases 1"
                    },
                    {
                        Frases: "Frases 2"
                    },
                    {
                        Frases: "Frases 3"
                    },
                    {
                        Frases: "Frases 4"
                    }
                ],
                AccionesP: 'Acciones',
                AccionesData: [{
                        Acciones: "Acciones 1"
                    },
                    {
                        Acciones: "Acciones 2"
                    },
                    {
                        Acciones: "Acciones 3"
                    },
                    {
                        Acciones: "Acciones 4"
                    }
                ],
                Respuestas: 'Respuestas',
                RespuestasData: [{
                        Respuestas: "Respuestas 1"
                    },
                    {
                        Respuestas: "Respuestas 2"
                    },
                    {
                        Respuestas: "Respuestas 3"
                    },
                    {
                        Respuestas: "Respuestas 4"
                    }
                ],
                Contexto: 'Contexto',
                ContextoData: [{
                        ContextoEntrada: "Contexto 1",
                        ContextoSalida: "Contexto 1"
                    },
                    {
                        ContextoEntrada: "Contexto 2",
                        ContextoSalida: "Contexto 1"
                    },
                    {
                        ContextoEntrada: "Contexto 3",
                        ContextoSalida: "Contexto 1"
                    },
                    {
                        ContextoEntrada: "Contexto 4",
                        ContextoSalida: "Contexto 1"
                    }
                ]
            }

        }
    }

}
</script>