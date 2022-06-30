import { Visual } from "../enum/visual.enum";
import { CustomFile } from "./customFile";

export interface Post {
    id : number;
    name : string;
    text : string;
    images: CustomFile[];
    visual: Visual;
}