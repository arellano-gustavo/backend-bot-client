<template>
    <div>
        <b-input-group :prepend="prepends" class="mb-2">
            <b-form-input aria-label="ContextoEntrada"></b-form-input>
            <b-form-input aria-label="ContextoSalida"></b-form-input>
            <b-input-group-append>
                <b-button size="sm" text="Button" variant="success">Agregar</b-button>
            </b-input-group-append>
        </b-input-group>
    </div>
</template>
<script>
export default {
    props:['prepends']
}
</script>