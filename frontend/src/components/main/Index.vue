<template>
    <div>
        <Post v-for="post in Object.values(this.posts).sort((a, b) => b.id - a.id)"
              :post="post" :users="users" :key="post.id"/>
    </div>
</template>

<script>
import Post from "../page/Post";
export default {
    name: "Index",
    components: {Post},
    props: ["posts", "users"]
}
</script>

<style scoped>

</style>
