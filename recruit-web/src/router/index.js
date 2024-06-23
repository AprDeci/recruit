import {createRouter,createWebHistory} from 'vue-router'



export const fixedRouter = [
    {
        path: '/',
        name: 'Home',
        component: () => import('../view/home/home.vue')
    },
    {
        path: '/job_detail/:id',
        name: 'job_detail',
        component: () => import('../view/home/jobdetail.vue'),
        props:true
    },
    {
        path: '/company/',
        name: 'company',
        component: () => import('../view/home/company.vue'),
        props:true,
        children:[
            {
                path: 'jobs/:id',
                name: 'companyjob',
                component: () => import('../view/home/companyjob.vue'),
                props:true,
                children:[
                    {
                    path:'type/:type?',
                    name:'companyjobtype',
                    component: () => import('../view/home/companyjobtype.vue'),
                    props:true
                }
            ]
            },
            {
                path:'info/:id',
                name:'companyinfo',
                component: () => import('../view/home/companyinfo.vue'),
                props:true
            }
        ]
    },
    {
        path:'/login',
        name:'login',
        component: () => import('../view/login/login.vue')
    },
    {
        path:'/register',
        name:'register',
        component: () => import('../view/login/register.vue')
    },
    {
        path:'/background',
        name:'background',
        component: () => import('../view/background/main.vue'),
        meta:{
            title:'后台管理',
        },
    },
    {
        path:'/search',
        name:'search',
        component: () => import('../view/home/search.vue'),
        props:route=>({query:route.query.query})
    },
]

// 求职者需要界面:个人信息编辑 个人简历编辑 求职记录查看 
// HR需要界面:HR信息编辑 企业简历查看 企业简历编辑 招聘信息查看 招聘信息

export const permissionRouter = [
    {
        path:'employee/user/info',
        name:'userinfo',
        component: () => import('@/view/background/employee/userinfo.vue'),
        meta:{
            title:'个人信息',
            roles:['employee'],
            icon:'User'
        },
    },
    {
        path:'employee/application',
        name:'employeeapplication',
        component: () => import('@/view/background/employee/applications.vue'),
        meta:{
            title:'简历信息',
            roles:['employee'],
            icon:'Postcard'
        },
    },
    {
        path:'employee/jobrecord',
        name:'jobrecord',
        component: () => import('@/view/background/employee/jobrecord.vue'),
        meta:{
            title:'求职记录',
            roles:['employee'],
            icon:'Memo'
        }
    },
    {
        path: 'employer/user/info',
        name: 'hrinfo',
        component: () => import('@/view/background/employer/userinfo.vue'),
        meta: {
            title: '个人信息',
            roles: ['employer'],
            icon:'User'
        }
    },
    {
        path: 'employer/company/info',
        name: 'company/info',
        component: () => import('@/view/background/employer/companyinfo.vue'),
        meta: {
            title: '企业信息',
            roles: ['employer'],
            icon:'House'
        }
    },
    {
        path: 'employer/job/add',
        name: 'addjob',
        component: () => import('@/view/background/employer/jobadd.vue'),
        meta: {
            title: '招聘职位管理',
            roles: ['employer'],
            icon:'DocumentAdd'
        }
    },
    {
        path: 'employer/jobrecords',
        name: 'employerjobrecords',
        component: () => import('@/view/background/employer/jobrecords.vue'),
        meta: {
            title: '招聘记录',
            roles: ['employer'],
            icon:'Memo'
        }
    },

]

const router = createRouter({
    history:createWebHistory(),
    routes: fixedRouter
})
export default router
