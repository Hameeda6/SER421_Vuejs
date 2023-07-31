import { createRouter, createWebHistory } from 'vue-router'
// import HomeView from '../views/HomeView.vue'
import AnalysisPage from '../views/AnalysisPage.vue'
import DemoPage from '../views/DemoPage.vue'
import HistoryPage from '../views/HistoryPage.vue'
import ResourcesPage from '../views/ResourcesPage.vue'
import TutorialPage from '../views/TutorialPage.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'history',
      component: HistoryPage
    },
    {
      path: '/tutorial',
      name: 'tutorial',
      component: TutorialPage
    },
    {
      path: '/demo',
      name: 'demo',
      component: DemoPage
    },
    {
      path: '/analysis',
      name: 'analysis',
      component: AnalysisPage
    },
    {
      path: '/resources',
      name: 'resources',
      component: ResourcesPage
    }
  ]
})

export default router
