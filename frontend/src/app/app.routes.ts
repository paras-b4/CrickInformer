import { Routes } from '@angular/router';
import { HistoryComponent } from './pages/history/history.component';
import { HomeComponent } from './pages/home/home.component';
import { LiveComponent } from './pages/live/live.component';
import { PointTableComponent } from './pages/point-table/point-table.component';

export const routes: Routes = [
    {
        path:'',
        redirectTo:"/home",
        pathMatch:"full"

    },
    {
        path:"home",
        component:HomeComponent,
        title:"Home | CrickInformer"
    },
    {
        path:"history",
        component:HistoryComponent,
        title:"Match history | CrickInformer"
    },
    {
        path:"live",
        component:LiveComponent,
        title:"Live Matches | CrickInformer"
    },
    {
        path:"point-table",
        component:PointTableComponent,
        title:"Point Table | CrickInformer"
    }

    
];
