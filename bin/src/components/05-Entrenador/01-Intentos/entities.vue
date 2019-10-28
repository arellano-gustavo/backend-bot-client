<template>
<div>
<h1>Entidades</h1>
<checks :options="options"></checks>
<context :prepend="pre.prepends"></context>
</div>
</template>
<script>
import checks from './06-Entidades/checks.vue'
import context from './01-Contexto/contextoP.vue'
export default {
    components:{
        checks,
        context
    },
     data() {
        return {
            selected: [],
            pre:{prepends:'Entrada/Salida'},
            options:[
                {text:'Define Synonyms',value:'1'},
                {text:'Regexp entity',value:'2'},
                {text:'Allow automated expansion',value:'3'},
                {text:'Fuzzy matching',value:'4'}
            ]
        }
     }
}
</script>