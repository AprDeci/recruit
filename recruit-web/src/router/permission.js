// 取到需要权限判断的路由表
import { permissionRouter, fixedRouter } from '@/router'
import {useUserStore} from '@/store/UserStore'
import router from '@/router'
import { useRouterStore } from '../store/routerStore'
var addRouFlag = false


router.beforeEach((to,from)=>{
    const userStore = useUserStore()
    const routerStore = useRouterStore()
    let role = userStore.role
    if (!addRouFlag&&to.path.startsWith('/background')){
        addRouFlag = true
        if(role === ''&&to.name!=='login'){
            return {name:'login'}
        }
        else{
            let getRoute = baseRoleGetRouters(permissionRouter, role.split(','))
            routerStore.setrouterList(getRoute)
            for(let i=0;i<getRoute.length;i++){
                router.addRoute("background",getRoute[i])
            }
            return {...to,replace:true}
        }
}       

}
)


function hasPermission(route, roles) {
  if (route.meta && route.meta.roles) {
    return roles.some(role => route.meta.roles.indexOf(role) >= 0)
  } else {
    return true
  }
}

function baseRoleGetRouters(allRoutes, roles) {
  let rightRoutes = allRoutes.filter((route, index) => {
    if (hasPermission(route, roles)) {
      if (route.children && route.children.length) {
        route.children = baseRoleGetRouters(route.children, roles)
      }
      return true
    }
    return false
  })
  return rightRoutes
}