import {Component} from "@angular/core"

@Component({
    selector: 'todo-cmp',
    template: `<todo-cmp (event)="fetch<caret>FromApi('')"</todo-cmp>`,
})
export class TodoCmp {
}
