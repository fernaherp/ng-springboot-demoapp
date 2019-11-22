import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ProductListComponent } from './products/product-list/product-list.component';
import { HomeComponent } from './home/home.component';
import { AuthGuard } from '../auth/auth.guard';


const protectedRoutes: Routes = [
  {
    path: 'protected',
    canActivate: [AuthGuard],
    children: [
      {
        path: '',
        canActivateChild: [AuthGuard],
        children: [
          { path: 'home', component: HomeComponent },
          { path: 'products/list', component: ProductListComponent },
          { path: 'products', redirectTo: 'products/list', pathMatch: 'full' },
          { path: '', redirectTo: 'home', pathMatch: 'full' }
        ]
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(protectedRoutes)],
  exports: [RouterModule]
})
export class ProtectedRoutingModule { }
