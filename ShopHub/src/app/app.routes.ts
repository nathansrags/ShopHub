import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './user/register/register.component';
import { RecoverComponent } from './user/recover/recover.component';
import { DashboardComponent } from './home/dashboard/dashboard.component';
import { CategoriesComponent } from './home/categories/categories.component';
import { ProductDetailComponent } from './product/product-detail/product-detail.component';
import { ProductListComponent } from './home/categories/product-list/product-list.component';

export const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: 'home', component: DashboardComponent },
  { path: 'logout', redirectTo: '/login', pathMatch: 'full' },
  { path: 'register', component: RegisterComponent },
  { path: 'recover', component: RecoverComponent },
  { path: 'category', component: CategoriesComponent},
  { path: 'category/:category', component:CategoriesComponent, pathMatch: 'full'},
  { path: 'product/:id', component: ProductDetailComponent, pathMatch: 'full'},
  { path: 'prodList', component: ProductListComponent},
  { path: 'shopping', component: DashboardComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {onSameUrlNavigation: 'reload'})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
