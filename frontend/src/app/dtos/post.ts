import { Visual } from "../enum/visual.enum";

export interface Post {
    id : number;
    name : string;
    text : string;
    image : string;
    visual: Visual;
}