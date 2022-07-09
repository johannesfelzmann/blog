import { Category } from "../enum/category.enum";
import { CustomFile } from "./customFile";

export interface Post {
    id : number;
    name : string;
    text : string;
    images: CustomFile[];
    category: Category;
    author: string;
}