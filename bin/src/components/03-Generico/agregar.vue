<template>
<div>
     <b-input-group  key="" size="" class="mb-3" :prepend="opcionesTab">
            <b-form-input></b-form-input>
            <b-input-group-append>
                <b-button size="sm" text="Button" variant="success">Agregar</b-button>
            </b-input-group-append>
        </b-input-group>
</div>
</template>
<script>
export default {
    props:['opcionesTab']
}
</script>