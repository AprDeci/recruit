import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'
import AutoImport from 'unplugin-auto-import/vite'
import Components from 'unplugin-vue-components/vite'
import { ElementPlusResolver } from 'unplugin-vue-components/resolvers'
import vitePluginRequire from "vite-plugin-require";


// https://vitejs.dev/config/
export default defineConfig({
  plugins: [
    vue()
  ,   vitePluginRequire.default(),
  AutoImport({
    resolvers: [ElementPlusResolver()],
  })
  , Components({
    resolvers: [ElementPlusResolver()],
  }),

  ],
  resolve:{
    //设置路径别名
    alias: {
      '@': __dirname + '/src',
      },
  },
  server:{
    proxy:{
      '/api':{
        target:'http://localhost:8080',
        changeOrigin:true,
        rewrite:(path)=>path.replace(/^\/api/,'')
      },
      "/baidu": {
        target: "https://api.map.baidu.com",
        ws: true,
        changeOrigin: true, //允许跨域
        rewrite:(path)=>path.replace(/^\/baidu/,'')
    }
  },
  base:'/',
}
})
