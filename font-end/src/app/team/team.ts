import { Player } from "../player/player";

export class Team {
    public id: number | null = null;
    public name: string | null = null;
    public playerList: Player[] = [];
}